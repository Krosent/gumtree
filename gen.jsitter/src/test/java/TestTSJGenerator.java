import com.github.gumtreediff.io.TreeIoUtils;
import com.github.gumtreediff.matchers.MappingStore;
import com.github.gumtreediff.matchers.Matcher;
import com.github.gumtreediff.matchers.Matchers;
import com.github.gumtreediff.matchers.SimilarityMetrics;
import com.github.gumtreediff.tree.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestTSJGenerator {
    // Test 1: Generate Parsed Tree
    @Test
    public void firstTest() throws IOException {
        // path to input file
        // String input = "treesitter_parser/sample.java";
        String input = "public class AddTwoIntegers {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        \n" +
                "        int first = 10;\n" +
                "        int second = 20;\n" +
                "\n" +
                "        System.out.println(\"Enter two numbers: \" + first + \" \" + second);\n" +
                "        int sum = first + second;\n" +
                "\n" +
                "        System.out.println(\"The sum is: \" + sum);\n" +
                "    }\n" +
                "}";
        // TreeContext ctx = new TreeSitterTreeGenerator().generateFrom().string(input);
        Tree tree = new TreeSitterTreeGenerator().generateFrom().string(input).getRoot();

        System.out.println(tree.toTreeString());
    }

    // Test 2: Similarity score test between two trees.
    @Test
    public void secondTest() throws IOException {

        // First tree input
        String input1 =
                "public static void main(String[] args) {\n" +
                        "\n" +
                        "        char ch = 'a';\n" +
                        "        int ascii = ch;\n" +
                        "        // You can also cast char to int\n" +
                        "        int castAscii = (int) ch;\n" +
                        "\n" +
                        "        System.out.println(\"The ASCII value of \" + ch + \" is: \" + ascii);\n" +
                        "        System.out.println(\"The ASCII value of \" + ch + \" is: \" + castAscii);\n" +
                        "    }";

        // Second tree input
        String input2 = "public class AsciiValue {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        char ch = 'a';\n" +
                "        int ascii = ch;\n" +
                "        // You can also cast char to int\n" +
                "        int castAscii = (int) ch;\n" +
                "\n" +
                "        System.out.println(\"The ASCII value of \" + ch + \" is: \" + ascii);\n" +
                "        System.out.println(\"The ASCII value of \" + ch + \" is: \" + castAscii);\n" +
                "    }\n" +
                "}";

        String input3 = "" +
                "public class SwapNumbers {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "\n" +
                "        float first = 1.20f, second = 2.45f;\n" +
                "\n" +
                "        System.out.println(\"--Before swap--\");\n" +
                "        System.out.println(\"First number = \" + first);\n" +
                "        System.out.println(\"Second number = \" + second);\n" +
                "\n" +
                "        // Value of first is assigned to temporary\n" +
                "        float temporary = first;\n" +
                "\n" +
                "        // Value of second is assigned to first\n" +
                "        first = second;\n" +
                "\n" +
                "        // Value of temporary (which contains the initial value of first) is assigned to second\n" +
                "        second = temporary;\n" +
                "\n" +
                "        System.out.println(\"--After swap--\");\n" +
                "        System.out.println(\"First number = \" + first);\n" +
                "        System.out.println(\"Second number = \" + second);\n" +
                "    }\n" +
                "}";

        // Tree generation
        TreeContext ctx1 = this.getTreeContext(input1);
        TreeContext ctx2 = this.getTreeContext(input2);
        TreeContext ctx3 = this.getTreeContext(input3);

        Tree t1 = ctx1.getRoot();
        Tree t2 = ctx2.getRoot();
        Tree t3 = ctx3.getRoot();

        System.out.println("Tree1: \n" + ctx1.getRoot().toTreeString());
        System.out.println("Tree2: \n" + ctx2.getRoot().toTreeString());
        System.out.println("Tree3: \n" + ctx3.getRoot().toTreeString());

        /*
         * Similarity Test
         */

        // Sample 1 vs Sample 2
        System.out.println("--- Sample 1 and Sample 2 Comparison ---");
        MappingStore ms = this.getMappingStore(t1, t2);
        displayStatistics(ms);
        System.out.println("--- Sample 1 and Sample 2 Comparison END ---");
        System.out.println(" ----- ");

        // Sample 1 vs Sample 3
        System.out.println("--- Sample 1 and Sample 3 Comparison ---");
        MappingStore _ms = this.getMappingStore(t1, t3);
        displayStatistics(_ms);
        System.out.println("--- Sample 1 and Sample 3 Comparison END ---");
        System.out.println(" ----- ");
    }

    public TreeContext getTreeContext(String input) throws IOException {
        return new TreeSitterTreeGenerator().generateFrom().string(input);
    }

    public MappingStore getMappingStore(Tree t1, Tree t2) {
        Matcher defaultMatcher = Matchers.getInstance().getMatcher(); // retrieves the default matcher
        return defaultMatcher.match(t1, t2); // computes the mappings between the trees
    }

    public void displayStatistics(MappingStore ms) {
        System.out.println("|||- Overlap similarity: " + SimilarityMetrics.overlapSimilarity(ms.src, ms.dst, ms));
        System.out.println("|||- Dice similarity: " + SimilarityMetrics.diceSimilarity(ms.src, ms.dst, ms));
        System.out.println("|||- Jaccard similarity: " + SimilarityMetrics.jaccardSimilarity(ms.src, ms.dst, ms));
        System.out.println("|||- Chawathe similarity: " + SimilarityMetrics.chawatheSimilarity(ms.src, ms.dst, ms));
    }
}
