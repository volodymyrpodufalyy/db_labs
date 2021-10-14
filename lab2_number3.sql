SELECT DISTINCT battle, date FROM labor_sql.outcomes JOIN battles ON (outcomes.battle = battles.name) WHERE result = 'OK'
