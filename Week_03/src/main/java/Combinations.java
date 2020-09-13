import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k<=0 || n<k){
            return res;
        }
        helper(res,n,k,1,new ArrayDeque<>());
        return res;
    }

    /**
     * 递归加回溯的方式实现，但没有进行剪枝
     * @param res 结果
     * @param n 候选数字集
     * @param k 选择数字的个数
     * @param begin 搜索路径的起点
     * @param path 路径
     */
    void helper(List<List<Integer>> res, int n, int k, int begin, Deque<Integer> path){
        if (path.size() == k){
            res.add(new ArrayList<>(path));
        }
        for (int i = begin; i <=n;i++){
            path.add(i);
            helper(res,n,k,i+1,path);
            // 这步太赞
            path.removeLast();
        }
    }

}
