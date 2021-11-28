package com.example.jpa;

import com.example.entity.FormtableMain47;
import com.example.entity.FormtableMain47Dt1;
import com.example.repository.FormtableMain47Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    FormtableMain47Repository formtableMain47Repository;

    @Test
    void contextLoads() {
        List<FormtableMain47> all = formtableMain47Repository.findAll();
        FormtableMain47 formtableMain47 = all.get(0);
        Set<FormtableMain47Dt1> formtableMain47Dt1 = formtableMain47.getFormtableMain47Dt1();
        List<FormtableMain47> collect = formtableMain47Dt1.stream().map(s -> s.getFormtableMain47()).collect(Collectors.toList());
        FormtableMain47 formtableMain471 = collect.get(0);
        Set<FormtableMain47Dt1> formtableMain47Dt11 = formtableMain471.getFormtableMain47Dt1();

    }

}
