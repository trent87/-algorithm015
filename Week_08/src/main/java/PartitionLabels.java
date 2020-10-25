import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        //字符出现的最后一个位置
        int[] charLastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            charLastIndex[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, charLastIndex[S.charAt(i) - 'a']);
            if (i == end) {
                //访问到片段结尾
                partition.add(end - start + 1);
                System.err.println(S.substring(start,end+1));
                start = end + 1;
            }
        }
        return partition;
    }
    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
    }
}
