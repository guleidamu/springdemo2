package Daily.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @ Author     ：damu
 * @ Date       ：Created in 14:53 2020/7/10
 * @ Modified By：
 * @Version: 1.0.0
 */
public class ListRemove {

    List<String> stringList = new ArrayList<>();
    public ListRemove(){
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");
        stringList.add("f");
        stringList.add("g");
        stringList.add("d");
        stringList.add("e");
        stringList.add("f");
        stringList.add("g");
    }

    //1.利用HashSet去重
    //利用list中的元素创建HashSet集合，此时set中进行了去重操作
    public void removeData(){
        Iterator it = stringList.iterator();
        while (it.hasNext()){
            String str = (String) it.next();
            System.out.println("str + >>>>" + str);
        }

        HashSet set = new HashSet(stringList);
        stringList.clear();
        stringList.addAll(set);
        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()){
            String string = (String)iterator.next();
            System.out.println("string >>> " + string);
        }
    }

    public static void main(String[] args) {
        ListRemove listRemove = new ListRemove();
//        listRemove.removeData();
        listRemove.byCycle();
    }

    //创建一个新的list集合，用于存储去重后的元素
    public void removeByContains(){
        //创建一个新的list集合，用于存储去重后的元素
        List listTemp = new ArrayList();
        //遍历list集合
        for(int i = 0; i< stringList.size(); i++){
            if(!listTemp.contains(stringList.get(i))){
                listTemp.add(stringList.get(i));
            }
        }
    }

    //循环list进行去重
    public void byCycle(){
        for (int i = 0; i <stringList.size() - 1; i++){
            for (int j = stringList.size() -1; j > i; j--){
                if (stringList.get(j).equals(stringList.get(i))){
                    stringList.remove(j);
                }
            }
        }

        Iterator iterator = stringList.iterator();
        while (iterator.hasNext()){
            String string = (String)iterator.next();
            System.out.println("string >>> " + string);
        }
    }
}
