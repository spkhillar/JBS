delete from QRTZ_FIRED_TRIGGERS;
delete from QRTZ_PAUSED_TRIGGER_GRPS;
delete from QRTZ_SCHEDULER_STATE;
delete from QRTZ_SIMPLE_TRIGGERS;
delete from QRTZ_CRON_TRIGGERS;
delete from QRTZ_BLOB_TRIGGERS;
delete from QRTZ_TRIGGERS;
delete from QRTZ_JOB_DETAILS;
delete from QRTZ_CALENDARS;

------


DROP TABLE IF EXISTS QRTZ_FIRED_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_PAUSED_TRIGGER_GRPS;
DROP TABLE IF EXISTS QRTZ_SCHEDULER_STATE;
DROP TABLE IF EXISTS QRTZ_SIMPLE_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_SIMPROP_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_CRON_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_BLOB_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_TRIGGERS;
DROP TABLE IF EXISTS QRTZ_JOB_DETAILS;
DROP TABLE IF EXISTS QRTZ_CALENDARS;
DROP TABLE IF EXISTS QRTZ_LOCKS;

---

update QRTZ_TRIGGERS set NEXT_FIRE_TIME= (((UNIX_TIMESTAMP()+5)*1000)+1) where TRIGGER_NAME='commisionDistributionJobTrigger'