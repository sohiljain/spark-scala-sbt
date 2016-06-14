/**
  * Created by sjain on 6/14/16.
  */

import org.apache.spark._

object SearchTextFile {

  def main(args: Array[String]): Unit = {

      var appName = "SearchTextFile"
      var master = "local"
      var conf = new SparkConf().setAppName(appName).setMaster(master)
      var sc = new SparkContext(conf)

      val lines = sc.textFile("/Users/sjain/2016_06_09")
      val pairs = lines.map(s => (s, 1))
      val counts = pairs.reduceByKey((a, b) => a + b)

      counts.foreach(println)


  }
}