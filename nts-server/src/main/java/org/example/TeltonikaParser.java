package org.example;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeltonikaParser {

    public static Map<String, Object> parseTeltonikaData(String hexData) {
        byte[] data = hexStringToByteArray(hexData);
        ByteBuffer buffer = ByteBuffer.wrap(data).order(ByteOrder.BIG_ENDIAN);

        // Preamble (4 bytes)
        int preamble = buffer.getInt();

        // Data Field Length (4 bytes)
        int dataFieldLength = buffer.getInt();

        // Codec ID (1 byte)
        byte codecId = buffer.get();

        // Number of Records (1 byte)
        int numRecords = buffer.get();

        List<Record> records = new ArrayList<>();

        // Parse each AVL Record
        for (int i = 0; i < numRecords; i++) {
            Record record = new Record();

            // Timestamp (8 bytes)
            record.timestamp = buffer.getLong();

            // Priority (1 byte)
            record.priority = Byte.toUnsignedInt(buffer.get());

            // GPS Element (15 bytes)
            record.longitude = buffer.getInt() / 10000000.0;
            record.latitude = buffer.getInt() / 10000000.0;
            record.altitude = buffer.getShort();
            record.angle = buffer.getShort();
            record.satellites = Byte.toUnsignedInt(buffer.get());
            record.speed = buffer.getShort();

            // IO Element
            record.ioElements = new HashMap<>();

            // Event IO ID and Total IO Count (2 bytes)
            int eventIoId = Byte.toUnsignedInt(buffer.get());
            int totalIoCount = Byte.toUnsignedInt(buffer.get());

            // Parse 1-byte IO Elements
            int n1 = Byte.toUnsignedInt(buffer.get());
            for (int j = 0; j < n1; j++) {
                int ioId = Byte.toUnsignedInt(buffer.get());
                int ioValue = Byte.toUnsignedInt(buffer.get());
                record.ioElements.put(ioId, ioValue);
            }

            // Parse 2-byte IO Elements
            int n2 = Byte.toUnsignedInt(buffer.get());
            for (int j = 0; j < n2; j++) {
                int ioId = Byte.toUnsignedInt(buffer.get());
                int ioValue = buffer.getShort();
                record.ioElements.put(ioId, ioValue);
            }

            // Parse 4-byte IO Elements
            int n4 = Byte.toUnsignedInt(buffer.get());
            for (int j = 0; j < n4; j++) {
                int ioId = Byte.toUnsignedInt(buffer.get());
                int ioValue = buffer.getInt();
                record.ioElements.put(ioId, ioValue);
            }

            // Parse 8-byte IO Elements
            int n8 = Byte.toUnsignedInt(buffer.get());
            for (int j = 0; j < n8; j++) {
                int ioId = Byte.toUnsignedInt(buffer.get());
                long ioValue = buffer.getLong();
                record.ioElements.put(ioId, ioValue);
            }

            records.add(record);
        }

        // Number of Records (should match the initial number of records) (1 byte)
        int numRecords2 = Byte.toUnsignedInt(buffer.get());

        // CRC (4 bytes)
        int crc = buffer.getInt();


        Map<String, Object> result = new HashMap<>();
        result.put("preamble", preamble);
        result.put("dataFieldLength", dataFieldLength);
        result.put("codecId", codecId);
        result.put("numRecords", numRecords);
        result.put("records", records);
        result.put("numRecords2", numRecords2);
        result.put("crc", crc);

        return result;
    }


    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }


}
