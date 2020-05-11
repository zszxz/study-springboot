CREATE TABLE "public"."tb_user" (
  "user_id" serial8,
  "user_name" varchar(20) COLLATE "pg_catalog"."default",
  "user_gender" varchar(8) COLLATE "pg_catalog"."default",
  "user_telephone" varchar(15) COLLATE "pg_catalog"."default"
)
;

ALTER TABLE "public"."tb_user"
  OWNER TO "postgres";