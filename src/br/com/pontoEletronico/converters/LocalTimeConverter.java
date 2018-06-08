/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pontoEletronico.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author ALMEIDA
 */
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, String> {

    @Override
    public String convertToDatabaseColumn(LocalTime attribute) {
        return attribute.format(DateTimeFormatter.ofPattern("hh:mm"));
    }

    @Override
    public LocalTime convertToEntityAttribute(String dbData) {
        return LocalTime.parse(dbData, DateTimeFormatter.ofPattern("hh:mm"));
    }

}
