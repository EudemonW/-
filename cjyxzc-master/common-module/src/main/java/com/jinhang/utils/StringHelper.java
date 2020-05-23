package com.jinhang.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringHelper {

    public static String GetMatcher(String regex, String source) {
        String result = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        while ( matcher.find() ) {
            result = matcher.group(1);//只取第一组
        }
        return result;
    }

    public static String GetCreateTableSQL( List<String> srcList,String srcTableName, String entitytableName , Map<String,String> map )
    {

        // 处理建表语句第一行
        String firstline = srcList.get(0).replace( "`"+srcTableName+"`" ,"`"+entitytableName+"`" );
        // 建表语句最后一行
        String lastline = srcList.get( srcList.size()-1 );

        // 建表语句中间部分
        List<String> midLines = new ArrayList<>();
        for( int i = 1 ; i < srcList.size() - 1 ; i++ )
        {
            String word = StringHelper.GetMatcher("`(.*?)`", srcList.get(i) );
            if( map.keySet().contains( "`" + word + "`"))
                midLines.add( srcList.get(i));
        }

        String midSql = String.join("",midLines ) ;
        // 修改字段
        for(  String key : map.keySet()  )
        {
            String value =  map.get(key);
            midSql = midSql.replace( key,value);
        }

        // 检查中间部分最后一行语句末尾逗号
        if( midSql.charAt(midSql.length()-1) == ',' )
            midSql = midSql.trim().substring( 0 , midSql.length()-1 );

        return firstline + midSql + lastline;
    }

    public static String GetInsertColumns( List<String> fields )
    {
        if( fields == null || fields.size() == 0 )
            return "*";
        return String.join(",",fields);
    }

    public static List<String> GetInsertValues(  List<Map> srcdatas ,List<String> fields )
    {
        List<String> datas = new ArrayList<>();
        for( Map<String,String> item : srcdatas )
        {
            List<String> dataList = new ArrayList<>();
            for( String data: fields )
                dataList.add( item.get(data) );

            datas.add(  "'" + String.join("','",dataList) + "'" );
        }
        return datas;
    }

    public static String GetPrimaryKey(  List<String> stats )
    {
        for( String line: stats )
        {
            if( line.toLowerCase().contains("primary key") )
                return StringHelper.GetMatcher("`(.*?)`",line );

        }
        return "";
    }

}
