package com.bomba.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoConfig;
import de.greenrobot.dao.Property;

import com.bomba.database.track;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TRACK.
*/
public class trackDao extends AbstractDao<track, Long> {

    public static final String TABLENAME = "TRACK";

    /**
     * Properties of entity track.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property A_legal_name = new Property(2, String.class, "a_legal_name", false, "A_LEGAL_NAME");
        public final static Property Stage_name = new Property(3, String.class, "stage_name", false, "STAGE_NAME");
        public final static Property Featured_a = new Property(4, String.class, "featured_a", false, "FEATURED_A");
        public final static Property Album_title = new Property(5, String.class, "album_title", false, "ALBUM_TITLE");
        public final static Property Track_number = new Property(6, Integer.class, "track_number", false, "TRACK_NUMBER");
        public final static Property Genre = new Property(7, String.class, "genre", false, "GENRE");
        public final static Property Cut = new Property(8, String.class, "cut", false, "CUT");
        public final static Property Producer = new Property(9, String.class, "producer", false, "PRODUCER");
        public final static Property Management = new Property(10, String.class, "management", false, "MANAGEMENT");
        public final static Property Label = new Property(11, String.class, "label", false, "LABEL");
        public final static Property Image_file = new Property(12, String.class, "image_file", false, "IMAGE_FILE");
        public final static Property Track_file = new Property(13, String.class, "track_file", false, "TRACK_FILE");
    };


    public trackDao(DaoConfig config) {
        super(config);
    }
    
    public trackDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TRACK' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'TITLE' TEXT," + // 1: title
                "'A_LEGAL_NAME' TEXT," + // 2: a_legal_name
                "'STAGE_NAME' TEXT," + // 3: stage_name
                "'FEATURED_A' TEXT," + // 4: featured_a
                "'ALBUM_TITLE' TEXT," + // 5: album_title
                "'TRACK_NUMBER' INTEGER," + // 6: track_number
                "'GENRE' TEXT," + // 7: genre
                "'CUT' TEXT," + // 8: cut
                "'PRODUCER' TEXT," + // 9: producer
                "'MANAGEMENT' TEXT," + // 10: management
                "'LABEL' TEXT," + // 11: label
                "'IMAGE_FILE' TEXT," + // 12: image_file
                "'TRACK_FILE' TEXT);"); // 13: track_file
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TRACK'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, track entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String a_legal_name = entity.getA_legal_name();
        if (a_legal_name != null) {
            stmt.bindString(3, a_legal_name);
        }
 
        String stage_name = entity.getStage_name();
        if (stage_name != null) {
            stmt.bindString(4, stage_name);
        }
 
        String featured_a = entity.getFeatured_a();
        if (featured_a != null) {
            stmt.bindString(5, featured_a);
        }
 
        String album_title = entity.getAlbum_title();
        if (album_title != null) {
            stmt.bindString(6, album_title);
        }
 
        Integer track_number = entity.getTrack_number();
        if (track_number != null) {
            stmt.bindLong(7, track_number);
        }
 
        String genre = entity.getGenre();
        if (genre != null) {
            stmt.bindString(8, genre);
        }
 
        String cut = entity.getCut();
        if (cut != null) {
            stmt.bindString(9, cut);
        }
 
        String producer = entity.getProducer();
        if (producer != null) {
            stmt.bindString(10, producer);
        }
 
        String management = entity.getManagement();
        if (management != null) {
            stmt.bindString(11, management);
        }
 
        String label = entity.getLabel();
        if (label != null) {
            stmt.bindString(12, label);
        }
 
        String image_file = entity.getImage_file();
        if (image_file != null) {
            stmt.bindString(13, image_file);
        }
 
        String track_file = entity.getTrack_file();
        if (track_file != null) {
            stmt.bindString(14, track_file);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public track readEntity(Cursor cursor, int offset) {
        track entity = new track( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // a_legal_name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // stage_name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // featured_a
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // album_title
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // track_number
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // genre
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // cut
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // producer
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // management
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // label
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // image_file
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13) // track_file
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, track entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setA_legal_name(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStage_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setFeatured_a(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAlbum_title(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setTrack_number(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setGenre(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setCut(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setProducer(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setManagement(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setLabel(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setImage_file(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setTrack_file(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(track entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(track entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}