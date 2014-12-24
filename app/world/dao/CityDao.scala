package world.dao

import java.sql.ResultSet
import world.model.City
import play.api.db.DB
import play.api.Play.current
import scala.annotation.tailrec

/**
 * @author petertran
 */
class CityDao {
  
  def getCities(countryCode: String): List[City] = {
    var conn = DB.getConnection("default")
    val resultSet = conn.createStatement.executeQuery(s"SELECT * FROM CITY WHERE CountryCode = '$countryCode'")
    val cities = queryCityTable(resultSet, Nil)
    conn.close
    cities
  }
  
  @tailrec
  final def queryCityTable(rs: ResultSet, acc: List[City]): List[City] = {
    if (!rs.next) acc
    else queryCityTable(rs, acc :+ returnCity(rs))
  }
  
  private def returnCity(rs: ResultSet): City = {
    new City(
      rs.getString("Name"),
      rs.getString("CountryCode"),
      rs.getString("District"),
      rs.getInt("Population"))
  }

}