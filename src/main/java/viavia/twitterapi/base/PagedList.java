package viavia.twitterapi.base;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PagedList<T> {
    private List<T> records;
    private long totalRecords;
    private long totalPages;

    public PagedList(List<T> records, long totalRecords, long totalPages) {
        this.records = records;
        this.totalRecords = totalRecords;
        this.totalPages = totalPages;
    }
}