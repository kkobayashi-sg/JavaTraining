DELETE FROM T_USER;  -- 既存のユーザーを一度消してから、入れ直すようにする
INSERT INTO T_USER VALUES ('user', '$argon2id$v=19$m=14,t=2,p=1$eVczdXhrMWlDZERWUnZWdA$HjSDtkidFBp49L0k8ZlvtTVcKkC//uOkIjDRiYbGIWg', true);

INSERT INTO t_charge (charge_id, name, amount, start_date, end_date)
VALUES (1, '基本料金', 1000, '2001-11-13', NULL);