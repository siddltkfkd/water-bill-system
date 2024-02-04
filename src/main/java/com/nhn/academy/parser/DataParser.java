package com.nhn.academy.parser;

import com.nhn.academy.data.WaterBill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class DataParser implements CsvDataParser{
    List<String> header;
    @Override
    public List<WaterBill> parse(String path) {
        List<WaterBill> waterBillList = new ArrayList<>();
        header = new ArrayList<>();

        File file = new File(path);
        BufferedReader br = null;
        String line;
        try{
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                String[] s = line.split("\\s*,\\s*");
                if (header.isEmpty()) {
                    header = Arrays.asList(s);
                }else {
                    waterBillList.add(new WaterBill(s[1].trim(), s[2].trim(), Integer.valueOf(s[6].trim()), 0));
                }
            }
            return waterBillList;
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try{
                if(Objects.nonNull(br)){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<String> getHeader() {
        return header;
    }
}
