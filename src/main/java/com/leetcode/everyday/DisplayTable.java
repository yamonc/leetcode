package com.leetcode.everyday;

import com.sun.xml.internal.ws.encoding.HasEncoding;

import javax.swing.*;
import java.util.*;

/**
 * @Author yamon
 * @Date 2021-07-06 14:36
 * @Description 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 *
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 * 示例 2：
 *
 * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],["1","2","0"],["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 * 示例 3：
 *
 * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Version 1.0
 */
public class DisplayTable {

    public List<List<String>> displayTable(List<List<String>> orders) {
        //从订单中获取餐品名称和桌号，统计每桌点餐数量
        Set<String> nameSet = new HashSet<>();
        //创建桌号->餐品、餐品数量的映射
        Map<Integer, Map<String,Integer>> footsCnt = new HashMap<>();
        for (List<String> order : orders) {
            //保存餐品名称
            nameSet.add(order.get(2));
            //获取订单中的桌号
            int id= Integer.parseInt(order.get(1));
            //根据桌号id创建餐品->餐品数量的map，然后将桌号和对应的餐品对应起来
            //根据id查找是否已经存有该桌号，如果已经有的话，直接返回。没有创建一个空的map
            Map<String, Integer> map = footsCnt.getOrDefault(id, new HashMap<String, Integer>());
            //根据餐品是否存在，如果存在的话，更新+1，没有的话创建新的。
            map.put(order.get(2), map.getOrDefault(order.get(2), 0)+1);
            //存进去。
            footsCnt.put(id, map);
        }
        //提取餐品名称，排序
        int n = nameSet.size();
        List<String> names = new ArrayList<>();
        names.addAll(nameSet);
        Collections.sort(names);
        //提取桌号，并按餐桌桌号升序排序
        int m = footsCnt.size();
        List<Integer> ids = new ArrayList<>();
        ids.addAll(footsCnt.keySet());
        Collections.sort(ids);

        //填写餐品展示表
        List<List<String>> table = new ArrayList<>();
        //填写第一行
        List<String> header = new ArrayList<>();
        header.add("Table");
        for(String name:names){
            header.add(name);
        }
        table.add(header);
        //填写第二行，桌号，菜品对应的数量
        for(int i = 0;i<m;i++){
            //取桌号
            List<String> row = new ArrayList<>();
            Integer id = ids.get(i);
            Map<String, Integer> map = footsCnt.get(id);
            row.add(id.toString());

            for(int j = 0;j<n;j++){
                row.add(Integer.toString(map.getOrDefault(names.get(j), 0)));
            }
            table.add(row);
        }
        return table;
    }

    public static void main(String[] args) {
        List<List<String>> demo = new ArrayList<>();
        List<String> c1 = new ArrayList<>();
        c1.add("David");
        c1.add("3");
        c1.add("Ceviche");
        demo.add(c1);
        List<String> c2 = new ArrayList<>();
        c2.add("Corina");
        c2.add("10");
        c2.add("Beef Burrito");
        demo.add(c2);
        List<String> c3 = new ArrayList<>();
        c3.add("David");
        c3.add("3");
        c3.add("Fried Chicken");
        demo.add(c3);
        List<String> c4 = new ArrayList<>();
        c4.add("Carla");
        c4.add("5");
        c4.add("Water");
        demo.add(c4);
        List<String> c5 = new ArrayList<>();
        c5.add("Carla");
        c5.add("5");
        c5.add("Ceviche");
        demo.add(c5);
        List<String> c6 = new ArrayList<>();
        c6.add("Rous");
        c6.add("3");
        c6.add("Ceviche");
        demo.add(c6);
        System.out.println(new DisplayTable().displayTable(demo));
    }
}
