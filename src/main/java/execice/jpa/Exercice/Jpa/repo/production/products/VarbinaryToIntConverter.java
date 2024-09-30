package execice.jpa.Exercice.Jpa.repo.production.products;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class VarbinaryToIntConverter implements AttributeConverter<Integer, byte[]> {
    @Override
    public byte[] convertToDatabaseColumn(Integer attribute) {
        if (attribute == null) {
            return null;
        }

        return new byte[] {
                (byte) (attribute >> 24),
                (byte) (attribute >> 16),
                (byte) (attribute >> 8),

        };
    }

    @Override
    public Integer convertToEntityAttribute(byte[] dbData) {
        if (dbData == null || dbData.length != 4) {
            return null;
        }

        return (dbData[0] & 0xFF) << 24 |
                (dbData[1] & 0xFF) << 16 |
                (dbData[2] & 0xFF) << 8 |
                (dbData[3] & 0xFF);
    }
}
