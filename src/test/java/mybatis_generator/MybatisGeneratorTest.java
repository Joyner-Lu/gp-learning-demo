package mybatis_generator;

import example.model.THomechargeOrder;
import org.mockito.Mock;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.mockito.Mockito.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 陆清云 luqy@xiaopeng.com
 * @version 1.00.00
 *
 * <pre>
 * 修改记录
 * 修改后版本: 修改人： 修改日期: 修改内容:
 * </pre>
 */
public class MybatisGeneratorTest {

    public static void main(String[] args) {
        generator();

    }

    public static void generator() {
        try {
            List<String> warnings = new ArrayList<>();
            Set<String> fullyqualifiedTables = new HashSet();
            ConfigurationParser cp = new ConfigurationParser(warnings);
            File
                    configurationFile = new File("D:\\gitSpace\\gp-learning-demo\\src\\main\\resources\\generatorConfig.xml");
            Configuration config = cp.parseConfiguration(configurationFile);
            DefaultShellCallback shellCallback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
            //ProgressCallback                    progressCallback = arguments.containsKey("-verbose") ? new VerboseProgressCallback() : null;
            Set<String> contexts = new HashSet();
            myBatisGenerator.generate(null, contexts, fullyqualifiedTables);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
