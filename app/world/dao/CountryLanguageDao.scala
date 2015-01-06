package world.dao

import java.sql.ResultSet
import play.api.db.DB
import play.api.Play.current
import scala.annotation.tailrec

/**
 * @author petertran
 */
class CountryLanguageDao {

	def getLanguagePercentages(countryName: String): List[(String, String, Integer)] = {
    var conn = DB.getConnection("default")
    val query = "SELECT L.Language, L.Percentage,".concat(
  		"ROUND((C.Population * (L.Percentage / 100)), 0) AS 'Language Population'").concat( 
    	s"FROM Country AS C JOIN CountryLanguage AS L ON C.CountryCode = L.CountryCode WHERE C.Name = '$countryName'")

    val resultSet = conn.createStatement.executeQuery(query)
    val languagePercentages = queryCountryLanguageTable(resultSet, Nil)
    conn.close
    languagePercentages
  }

  @tailrec
  final def queryCountryLanguageTable(rs: ResultSet, acc: List[(String, String, Integer)]): List[(String, String, Integer)] = {
    if (!rs.next) acc
    else queryCountryLanguageTable(rs, acc :+ returnLanguagePercentage(rs))
  }

  private def returnLanguagePercentage(rs: ResultSet): (String, String, Integer) = {
    (rs.getString("Language"), rs.getString("Percentage"), rs.getInt("Language Population"))
  }

}