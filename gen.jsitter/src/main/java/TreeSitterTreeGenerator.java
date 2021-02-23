import com.github.gumtreediff.gen.ExternalProcessTreeGenerator;
import com.github.gumtreediff.gen.Register;
import com.github.gumtreediff.gen.Registry;
import com.github.gumtreediff.io.TreeIoUtils;
import com.github.gumtreediff.tree.TreeContext;

import java.io.IOException;
import java.io.Reader;

@Register(id = "java-tree-sitter-parser", accept = {"\\.java$"}, priority = Registry.Priority.MAXIMUM)
public class TreeSitterTreeGenerator extends ExternalProcessTreeGenerator {
    // Link to Tree Sitter Parser Script
    private static final String JAVA_PARSER_CMD =
            "/Users/artyomkuznetsov/PycharmProjects/GumtreeXmlGenerator/main.py";

    @Override
    protected TreeContext generate(Reader r) throws IOException {
        String output = readStandardOutput(r);
//        String output = "<?xml version=\"1.0\" ?>\n" +
//                "<root>\n" +
//                "\t<context/>\n" +
//                "\t<tree type=\"program\" pos=\"0\" length=\"301\">\n" +
//                "\t\t<tree type=\"class_declaration\" pos=\"0\" length=\"300\">\n" +
//                "\t\t\t<tree type=\"modifiers\" pos=\"0\" length=\"6\">\n" +
//                "\t\t\t\t<tree type=\"public\" pos=\"0\" length=\"6\"/>\n" +
//                "\t\t\t</tree>\n" +
//                "\t\t\t<tree type=\"class\" pos=\"7\" length=\"5\"/>\n" +
//                "\t\t\t<tree type=\"identifier\" pos=\"13\" length=\"14\"/>\n" +
//                "\t\t\t<tree type=\"class_body\" pos=\"28\" length=\"272\">\n" +
//                "\t\t\t\t<tree type=\"{\" pos=\"28\" length=\"1\"/>\n" +
//                "\t\t\t\t<tree type=\"method_declaration\" pos=\"34\" length=\"264\">\n" +
//                "\t\t\t\t\t<tree type=\"modifiers\" pos=\"34\" length=\"13\">\n" +
//                "\t\t\t\t\t\t<tree type=\"public\" pos=\"34\" length=\"6\"/>\n" +
//                "\t\t\t\t\t\t<tree type=\"static\" pos=\"41\" length=\"6\"/>\n" +
//                "\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t<tree type=\"void_type\" pos=\"48\" length=\"4\"/>\n" +
//                "\t\t\t\t\t<tree type=\"identifier\" pos=\"53\" length=\"4\"/>\n" +
//                "\t\t\t\t\t<tree type=\"formal_parameters\" pos=\"57\" length=\"15\">\n" +
//                "\t\t\t\t\t\t<tree type=\"(\" pos=\"57\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t<tree type=\"formal_parameter\" pos=\"58\" length=\"13\">\n" +
//                "\t\t\t\t\t\t\t<tree type=\"array_type\" pos=\"58\" length=\"8\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"type_identifier\" pos=\"58\" length=\"6\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"dimensions\" pos=\"64\" length=\"2\">\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"[\" pos=\"64\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"]\" pos=\"65\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"67\" length=\"4\"/>\n" +
//                "\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t<tree type=\")\" pos=\"71\" length=\"1\"/>\n" +
//                "\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t<tree type=\"block\" pos=\"73\" length=\"225\">\n" +
//                "\t\t\t\t\t\t<tree type=\"{\" pos=\"73\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t<tree type=\"local_variable_declaration\" pos=\"92\" length=\"15\">\n" +
//                "\t\t\t\t\t\t\t<tree type=\"integral_type\" pos=\"92\" length=\"3\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"int\" pos=\"92\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\"variable_declarator\" pos=\"96\" length=\"10\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"96\" length=\"5\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"=\" pos=\"102\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"decimal_integer_literal\" pos=\"104\" length=\"2\"/>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\";\" pos=\"106\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t<tree type=\"local_variable_declaration\" pos=\"116\" length=\"16\">\n" +
//                "\t\t\t\t\t\t\t<tree type=\"integral_type\" pos=\"116\" length=\"3\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"int\" pos=\"116\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\"variable_declarator\" pos=\"120\" length=\"11\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"120\" length=\"6\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"=\" pos=\"127\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"decimal_integer_literal\" pos=\"129\" length=\"2\"/>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\";\" pos=\"131\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t<tree type=\"expression_statement\" pos=\"142\" length=\"65\">\n" +
//                "\t\t\t\t\t\t\t<tree type=\"method_invocation\" pos=\"142\" length=\"64\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"field_access\" pos=\"142\" length=\"10\">\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"142\" length=\"6\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\".\" pos=\"148\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"149\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\".\" pos=\"152\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"153\" length=\"7\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"argument_list\" pos=\"160\" length=\"46\">\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"(\" pos=\"160\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"binary_expression\" pos=\"161\" length=\"44\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t<tree type=\"binary_expression\" pos=\"161\" length=\"35\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<tree type=\"binary_expression\" pos=\"161\" length=\"29\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t<tree type=\"string_literal\" pos=\"161\" length=\"21\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t<tree type=\"+\" pos=\"183\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"185\" length=\"5\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<tree type=\"+\" pos=\"191\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t<tree type=\"string_literal\" pos=\"193\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t\t\t\t<tree type=\"+\" pos=\"197\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"199\" length=\"6\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\")\" pos=\"205\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\";\" pos=\"206\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t<tree type=\"local_variable_declaration\" pos=\"216\" length=\"25\">\n" +
//                "\t\t\t\t\t\t\t<tree type=\"integral_type\" pos=\"216\" length=\"3\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"int\" pos=\"216\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\"variable_declarator\" pos=\"220\" length=\"20\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"220\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"=\" pos=\"224\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"binary_expression\" pos=\"226\" length=\"14\">\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"226\" length=\"5\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"+\" pos=\"232\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"234\" length=\"6\"/>\n" +
//                "\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\";\" pos=\"240\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t<tree type=\"expression_statement\" pos=\"251\" length=\"41\">\n" +
//                "\t\t\t\t\t\t\t<tree type=\"method_invocation\" pos=\"251\" length=\"40\">\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"field_access\" pos=\"251\" length=\"10\">\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"251\" length=\"6\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\".\" pos=\"257\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"258\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\".\" pos=\"261\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"262\" length=\"7\"/>\n" +
//                "\t\t\t\t\t\t\t\t<tree type=\"argument_list\" pos=\"269\" length=\"22\">\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"(\" pos=\"269\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\"binary_expression\" pos=\"270\" length=\"20\">\n" +
//                "\t\t\t\t\t\t\t\t\t\t<tree type=\"string_literal\" pos=\"270\" length=\"14\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t<tree type=\"+\" pos=\"285\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t\t<tree type=\"identifier\" pos=\"287\" length=\"3\"/>\n" +
//                "\t\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t\t\t<tree type=\")\" pos=\"290\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t\t<tree type=\";\" pos=\"291\" length=\"1\"/>\n" +
//                "\t\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t\t\t<tree type=\"}\" pos=\"297\" length=\"1\"/>\n" +
//                "\t\t\t\t\t</tree>\n" +
//                "\t\t\t\t</tree>\n" +
//                "\t\t\t\t<tree type=\"}\" pos=\"299\" length=\"1\"/>\n" +
//                "\t\t\t</tree>\n" +
//                "\t\t</tree>\n" +
//                "\t</tree>\n" +
//                "</root>";
        return TreeIoUtils.fromXml().generateFrom().string(output);
    }

    @Override
    protected String[] getCommandLine(String file) {
        return new String[]{JAVA_PARSER_CMD, file};
    }
}
