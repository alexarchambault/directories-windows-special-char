import java.io._

import io.github.soc.directories.ProjectDirectories

object Check {
  def main(args: Array[String]): Unit = {
    val directories = ProjectDirectories.from(null, null, "Foo")
	val userDirViaDirectories = new File(new File(directories.cacheDir).getAbsolutePath, "..\\..\\..\\..").getCanonicalFile
	val userDirViaLocalAppData = new File(new File(sys.env("LOCALAPPDATA")).getAbsolutePath, "..\\..").getCanonicalFile
	
	val dirNameViaDirectories = userDirViaDirectories.getName
	val dirNameViaLocalAppData = userDirViaLocalAppData.getName
	
	println(s"dirNameViaDirectories=$dirNameViaDirectories")
	println(s"dirNameViaLocalAppData=$dirNameViaLocalAppData")
	assert(dirNameViaDirectories == dirNameViaLocalAppData, s"$dirNameViaDirectories != $dirNameViaLocalAppData")
  }
}
