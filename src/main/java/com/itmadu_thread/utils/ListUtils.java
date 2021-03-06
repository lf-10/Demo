package com.itmadu_thread.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @classDesc: 功能描述（java工具类）
 * @Auther: 李府
 * @Date: 2020/07/14/11:21
 * @Description:
 */
public class ListUtils {
    public static <T>List<List<T>> splitList(List<T> list, int pageSize){
        int listSize = list.size();
        int page=(listSize+(pageSize-1))/pageSize;
        List<List<T>> listArray = new ArrayList<List<T>>();
        for (int i = 0; i <page ; i++) {
            List<T> subList = new ArrayList<T>();
            for (int j = 0; j <listSize ; j++) {
                int pageIndex=((j+1)+(pageSize-1))/pageSize;
                if (pageIndex==(i+1)){
                    subList.add(list.get(j));
                }
                if ((j+1)==((j+1)*pageSize)){
                  break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }
}
