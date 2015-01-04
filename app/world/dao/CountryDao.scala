package world.dao

import java.sql.ResultSet
import world.model.Country
import play.api.db.DB
import play.api.Play.current
import scala.annotation.tailrec

class CountryDao {
  
  def getCountries(region: String): List[Country] = {
    var conn = DB.getConnection("default")
    val resultSet = conn.createStatement.executeQuery(s"SELECT * FROM COUNTRY WHERE Region = '$region'")
    val countries = queryCountryTable(resultSet, Nil)
    conn.close
    countries
  }
  
  @tailrec
  final def queryCountryTable(rs: ResultSet, acc: List[Country]): List[Country] = {
    if (!rs.next) acc
    else queryCountryTable(rs, acc :+ returnCountry(rs))
  }

  private def returnCountry(rs: ResultSet): Country = {
    new Country(
      rs.getString("Name"),
      rs.getString("Region"),
      rs.getDouble("SurfaceArea"),
      rs.getInt("Population")
    )
  }

}