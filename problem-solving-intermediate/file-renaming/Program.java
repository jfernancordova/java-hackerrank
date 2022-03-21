package practice.file_renaming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Program {

    // O(n ^ 2) time | O(n) space
    public static int renameFile(String newName, String oldName) {
        int newNameLength = newName.length();
        int oldNameLength = oldName.length();

        int[] output = new int[oldNameLength + 1];
        Arrays.fill(output, 1);

        for (int i = 1; i < newNameLength + 1; i++) {
            int[] iterativeOutput = new int[oldNameLength + 1];
            Arrays.fill(iterativeOutput, 0);

            for (int j = i; j < oldNameLength + 1; j++) {
                iterativeOutput[j] = iterativeOutput[j - 1];
                if (newName.charAt(i - 1) == oldName.charAt(j - 1)) {
                    iterativeOutput[j] += output[j - 1];
                }
            }

            output = iterativeOutput;
        }

        return output[output.length - 1];
    }
}

class ProgramTest {

    @Test
    void testCaseOne() {
        int result = Program.renameFile("ccc", "cccc");
        Assertions.assertEquals(4, result);
    }

    @Test
    void testCaseTwo() {
        int result = Program.renameFile("abc", "abba");
        Assertions.assertEquals(0, result);
    }

    @Test
    void testCaseThree() {
        int result = Program.renameFile("rcz", "rrrrccccccccccccccccccccccccccccccccccccccccccccccczzzzzzzzzzcccccccccccccccczzzzzcccccccccczzzzzzzzzz");
        Assertions.assertEquals(6060, result);
    }

    @Test
    void testCaseFour() {
        int result = Program.renameFile("rrk", "eispnddxtnfqalswxsmksfooiwxynamdjxnsmkiewkwdpzjpkibcbbmzbiwpmjczcehtczqjzlkgyvszpuuvetdfluuhxpeopuxmdylaysttenjmcedcumoeeicjtxkkvxcxjowrcvlttsqhwkbbmigtqlovjgviyzgcqjvpvotwucsetidicyhtcmajphxyyooeovuxvuploklpbovqdwdypbxgajuqwadgeedjkgurhsxdvylmyfjqlwzldrouylqobsgemwdoibqvcyedfvqopfhkqmhusxqacoogjxcoxbfzlwcxfvqaavfegkcirqqgdyhljmaqzqifuaoubukypavebvdujgsulahkprfpnzqaqgvfdxwtqflceilpmszizfwbonxplcyqittpkpbcfsesgfbiqnipolefrelphjthqrzsphbnumgrifmwiztfuhqibgaxdvysyvgxlspminykbyumepubrxuoavyovdbielzdobgqcjznjbexalkghywioxzbvxzfcshcozmefwcrvyibjdfqvqmhxdpccjodlgvkplrfdedpzoprfeechwszhvcdooejlchcwcektfrdmowhsueavbrawmihzsnfhrafbqeawdixznppfwieaivtmpqzqtsvnvwjmgvhuesssaxgmoywdgvwiouzuqdebijcqycftaftuwtgxavemciuqmxenprpmyzrexshnvtesstwhytmatxbuzxpstpygfxphpfckjdbfbximeeswyndfhomcnwjtfruvzwbhlzbvebyeucepgcdpmghcibfxg");
        Assertions.assertEquals(339, result);
    }
}