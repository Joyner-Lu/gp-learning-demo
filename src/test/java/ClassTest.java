import org.springframework.util.StringUtils;
import sun.misc.Unsafe;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqingyun@foresee.cn
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class ClassTest {

    private static final String prefix = "update `t_evcs_order` e \n" +
                                         "join o_order_charge o \n" +
                                         "on e.order_no = o.order_no and e.evcs_order_type = 2";


    private static final String suffix = "\n set e.gun_id  = o.equip_id; \n";

    public static void main(String[] args) throws Exception{
        Path path = Paths.get("D:\\gitSpace\\demo_test\\拆分-小事务.sql");
        List<String> stringList = Files.readAllLines(path);
        StringBuilder sb = new StringBuilder();
        for (String line : stringList) {
            if (StringUtils.isEmpty(line.trim())) {
                continue;
            }
            if (line.contains("create_time")) {
                line = " " + line;
                line = line.replace("create_time", "e.create_time");
                if (line.contains("where")) {
                    line = line.replace("where", "and");
                }
                sb.append(line);
                if (line.contains(";")) {
                    sb.append("\n");
                }

            }
        }
        //System.out.println(sb.toString());
        String[] split = sb.toString().split(";");
        StringBuilder newSb = new StringBuilder();
        for (String con : split) {
            if (StringUtils.isEmpty(con.trim())) {
                continue;
            }
            newSb.append(prefix);
            newSb.append(con);
            newSb.append(suffix);
            newSb.append("\n");
        }

        System.out.println(newSb.toString());
    }

    public static void compare() throws Exception{
        Path path = Paths.get("D:\\gitSpace\\demo_test\\拆分-小事务.sql");

        List<String> stringList = Files.readAllLines(path);
        boolean first = true;
        String andTime = "";
        String whereTime = "";
        for (String line : stringList) {
            if (line.contains("from") || line.contains("select") || StringUtils.isEmpty(line.trim())) {
                continue;
            }
            if (line.contains("create_time") && line.contains("and")) {
                //and time
                String[] split = line.split("<");
                andTime = split[1].trim().substring(0, split[1].length() - 2);
                whereTime = "";
            }

            if (line.contains("create_time") && line.contains("where")) {
                if (first) {
                    first = false;
                    continue;
                }
                //where time
                String[] split = line.split(">=");
                whereTime = split[1].trim();
                System.out.println(whereTime);
            }
            if (!StringUtils.isEmpty(andTime) && !StringUtils.isEmpty(whereTime)) {
                if (!andTime.equals(whereTime)) {
                    throw new Exception(line);
                }
            }

        }
    }
}
