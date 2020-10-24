package RankUp.AktuellStufe4;

//https://www.codewars.com/kata/52bef5e3588c56132c0003bc
import java.util.*;

public class Kata {
    public static List<Integer> treeByLevels(Node node)	{
        ArrayList<Integer> output=new ArrayList<>();
        ArrayList<Node> nodes=new ArrayList<>();
        if(node==null){
            return new ArrayList<>();
        }
        nodes.addAll(Arrays.asList(node));
        for(int i=0;i< nodes.size();i++){
            Optional.ofNullable(nodes.get(i).left).ifPresent(currentNode -> nodes.add(currentNode));
            Optional.ofNullable(nodes.get(i).right).ifPresent(currentNode -> nodes.add(currentNode));
        }
        nodes.forEach(currentNode->output.add(currentNode.value));
        return output;
	}
}
