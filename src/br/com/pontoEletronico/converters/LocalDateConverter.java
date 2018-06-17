
package br.com.pontoEletronico.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String>{

    @Override
    public String convertToDatabaseColumn(LocalDate attribute) {
        return attribute.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        return LocalDate.parse(dbData, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
}
