
package br.com.pontoEletronico.converters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


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
