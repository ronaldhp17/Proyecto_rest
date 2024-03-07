package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ModelToDummyapi {
    private String name;
    private String salary;
    private String age;

    public static List<ModelToDummyapi> setData(DataTable dataTable) {
        List<ModelToDummyapi> dates = new ArrayList<>();
        List<Map<String, String>>mapInfo = dataTable.asMaps();
        for (Map<String,String>map : mapInfo){
            dates.add(new ObjectMapper().convertValue(map, ModelToDummyapi.class));
        }
        return dates;
    }

    @Override
    public String toString(){
        return "{" +
                "\"name\":" + '\"' + name + '\"' +
                ", \"salary\":" + '\"' + salary + '\"' +
                ", \"age\":" + '\"' + age + '\"'+
                '}';
    }
}
