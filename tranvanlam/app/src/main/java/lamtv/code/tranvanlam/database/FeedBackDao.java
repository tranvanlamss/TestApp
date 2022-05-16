package lamtv.code.tranvanlam.database;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FeedBackDao {

    @Insert
    void insertFeedBack(FeedBackEntity fb);

    @Query("SELECT * FROM feedback")
    List<FeedBackEntity> getListFeedback();
}
