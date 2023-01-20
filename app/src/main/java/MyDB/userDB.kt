package MyDB

import android.provider.BaseColumns

object userDB{
    class userTable : BaseColumns{
        companion object{
            val TABLE_USER = "tbl_user"
            val COLUMN_USERNAME = "Username"
            val COLUMN_PASSWORD = "Password"
            val COLUMN_UMKM = "UMKM"
            val COLUMN_SUPPLIER = "SUPPLIER"
        }
    }
}