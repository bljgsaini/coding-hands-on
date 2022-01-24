package tree;

import java.util.*;

public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        List<List<Integer>>ans = levelOrderTraversal.levelOrder(root);

        for( List<Integer> list : ans) {
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int k = q.size();
            List<Integer>list = new ArrayList<>();
            for(int i=0; i<k; i++){
                TreeNode temp = q.poll();
                list.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right != null ) q.add(temp.right);
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        levelOrderUtil(root, 0, map);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> values : map.values()){
            ans.add(values);
        }
        return ans;
    }

    public void levelOrderUtil(TreeNode root, int level, Map<Integer, List<Integer> >map){
        if(root == null ) return;
        List<Integer> ans = map.getOrDefault(level, new ArrayList<Integer>());
        ans.add(root.val);
        map.put(level, ans);
        levelOrderUtil(root.left, level+1, map);
        levelOrderUtil(root.right, level+1, map);
    }

}
