import java.io._



def gen_liste(rep:String,fileIn:String,fileOut:String,nbIte:Int) = {
	
	val writer=new PrintWriter(new File(rep+"\\"+fileOut));
	var res = List[List[Double]]();

	for (i <- 0 to nbIte-1) {
		var l = List[Double]();
		val csv = scala.io.Source.fromFile(rep+"\\"+fileIn);
		val iter=csv.getLines().drop(1).map(_.split(";"));
		iter.foreach(line => l++=List(line(17).toDouble)); //if (line(0)==i.toString) {}
		res++=List(l.sortWith(_>_));
		println(res(i).length);
	}

	for (i <- 0 to nbIte-1) {
		for (j <- 0 to res(i).length-1) {
			writer.write(res(i)(j)+",");
		}
		writer.write("\n");
	}
	writer.close();
}


gen_liste("F:\\Perso\\Geographie\\Carthageo\\Stage\\MARIUS","marius_real.csv","marius_real.txt",1);
