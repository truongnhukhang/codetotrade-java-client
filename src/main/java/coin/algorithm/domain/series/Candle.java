package coin.algorithm.domain.series;

import org.apache.commons.csv.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Candle {
    long startTime;
    long endTime;
    double open;
    double close;
    double high;
    double low;
    double volume;
    long duration;

    public byte[] toBytes() {
        byte[] bytes = new byte[56];
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.putLong(startTime);
        buffer.putLong(endTime);
        buffer.putDouble(open);
        buffer.putDouble(close);
        buffer.putDouble(high);
        buffer.putDouble(low);
        buffer.putDouble(volume);
        buffer.putLong(duration);
        return buffer.array();
    }

    public Candle(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        startTime = buffer.getLong();
        endTime = buffer.getLong();
        open = buffer.getDouble();
        close = buffer.getDouble();
        high = buffer.getDouble();
        low = buffer.getDouble();
        volume = buffer.getDouble();
        duration = buffer.getLong();
    }
    public Candle() {
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public static List<Candle> loadCandlesFromCSV(String filePath) throws Exception {
        List<Candle> candles = new ArrayList<>();
        try (Reader reader = new FileReader(filePath)) {
            CSVParser csvParser = new CSVParser(reader,
                                                CSVFormat.DEFAULT.builder().setHeader("startTime",
                                                                                      "endTime",
                                                                                      "open",
                                                                                      "close",
                                                                                      "high",
                                                                                      "low",
                                                                                      "volume",
                                                                                      "duration")
                                                                 .setSkipHeaderRecord(true).setIgnoreHeaderCase(true)
                                                                 .setTrim(true).build());
            for (CSVRecord csvRecord : csvParser) {
                Candle candle = new Candle();
                candle.setStartTime(Long.parseLong(csvRecord.get("startTime")));
                candle.setEndTime(Long.parseLong(csvRecord.get("endTime")));
                candle.setOpen(Double.parseDouble(csvRecord.get("open")));
                candle.setClose(Double.parseDouble(csvRecord.get("close")));
                candle.setHigh(Double.parseDouble(csvRecord.get("high")));
                candle.setLow(Double.parseDouble(csvRecord.get("low")));
                candle.setVolume(Double.parseDouble(csvRecord.get("volume")));
                candle.setDuration(Long.parseLong(csvRecord.get("duration")));
                candles.add(candle);
            }
        }
        return candles;
    }

    public static void writeCandlesToCsv(List<Candle> candles, String filePath) throws Exception {
        try (FileWriter writer = new FileWriter(filePath)) {
            CSVPrinter csvPrinter = new CSVPrinter(writer,
                                                   CSVFormat.DEFAULT.builder().setHeader("startTime",
                                                                                         "endTime",
                                                                                         "open",
                                                                                         "close",
                                                                                         "high",
                                                                                         "low",
                                                                                         "volume",
                                                                                         "duration").build());
            for (Candle candle : candles) {
                csvPrinter.printRecord(candle.getStartTime(),
                                       candle.getEndTime(),
                                       candle.getOpen(),
                                       candle.getClose(),
                                       candle.getHigh(),
                                       candle.getLow(),
                                       candle.getVolume(),
                                       candle.getDuration());
            }

            csvPrinter.flush();
        }
    }
}

