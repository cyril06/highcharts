import java.io._

def gen_range(rep:String,fileIn:String,fileOut:String,nbIte:Int) = {
	
	val writer=new PrintWriter(new File(rep+"\\"+fileOut));
	var res = List[List[Double]]();
	var resDim = List[List[Double]]();

	for (i <- 0 to nbIte-1) {
		var l = List[Double]();
		val csv = scala.io.Source.fromFile(rep+"\\"+fileIn);
		val iter=csv.getLines().drop(1).map(_.split(";"));
		iter.foreach(line => if (line(0)==i.toString) {l++=List(line(1).toDouble);}); //if (line(0)==i.toString) {}
		res++=List(l.sortWith(_>_));
	}


	for (i <- 0 to res(0).length-1) {
		var l = List[Double]();
		l=res.map(m=>m(i))
		resDim++=List(List(l.min.toDouble,l.max.toDouble));
	}	
		
	writer.write("var ranges = [");
	for (i <- 0 to resDim.length-1) {
		writer.write("[");
		for (j <- 0 to 1) {
			if (j==0)
				writer.write(i+1+","+resDim(i)(j)+",");
			else
				writer.write(resDim(i)(j).toString);
		}
		if (i!=resDim.length-1) 
			writer.write("],");
		else
			writer.write("]");
	}
	writer.write("];");
	writer.close();
}


gen_range("F:\\Perso\\Geographie\\Carthageo\\Stage\\MARIUS","test2.txt","marius_range_marius00_50.js",49);