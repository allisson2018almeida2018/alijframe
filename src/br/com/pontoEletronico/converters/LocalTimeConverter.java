<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======

>>>>>>> upstream/master
package br.com.pontoEletronico.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

<<<<<<< HEAD
/**
 *
 * @author ALMEIDA
 */
=======

>>>>>>> upstream/master
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalTime attribute) {
        return attribute.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Override
    public LocalTime convertToEntityAttribute(String dbData) {
        return LocalTime.parse(dbData, DateTimeFormatter.ofPattern("HH:mm"));
    }

}
