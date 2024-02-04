package com.nhn.academy.parser;

import com.nhn.academy.data.Tariff;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CsvDataParserImpl implements CsvDataParser{
    List<String> header;
    @Override
    public List<Tariff> parse(String path) {
        List<Tariff> tariffList = new ArrayList<>();
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
                } else if(Arrays.asList(s).size() == 7){
                    tariffList.add(new Tariff(
                            Integer.valueOf(s[0].trim())
                            , s[1].trim()
                            , s[2].trim()
                            , Integer.valueOf(s[3].trim())
                            , Integer.valueOf(s[4].trim())
                            , Integer.valueOf(s[5].trim())
                            , Integer.valueOf(s[6].trim())
                            , ""
                    ));
                } else {
                    tariffList.add(new Tariff(
                            Integer.valueOf(s[0].trim())
                            , s[1].trim()
                            , s[2].trim()
                            , Integer.valueOf(s[3].trim())
                            , Integer.valueOf(s[4].trim())
                            , Integer.valueOf(s[5].trim())
                            , Integer.valueOf(s[6].trim())
                            , s[7].trim()
                    ));
                }
            }
            return tariffList;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
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
