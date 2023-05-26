####Standard In,Output
    (System.in, Sysytem.out)
    
######Scanner
    Declare : Scanner name = new Scanner(System.in);
    Form : name.next(type)();

######Console 
    Declare : Console name = System.console();
    Form : name.read();, name.readPassword();

####Input(&Output) Stream
Data type : byte

######FileInputStream(&Output)
    Declare : FileInputStream name = new FileInputStream(File or Path)
            with try-catch or try-resource
    Form : name.read();, name.write(Something);

####Reader(&Writer)
Data type : Character

######FileReader(&Writer)
    Declare : FileReader name = new FileReader(File or Path);
    Form : name.read();, name.write(Something);

####Wrapper Stream

######InputStreamReader(&Writer)
    Declare : InputStreamReader name = new InputStreamReader(InputStream);
    Form : name.read();, name.write(Something);

######BufferedInputStream
    Declare : BufferedInputStream name = new BufferedInputStream(InputStream); 
    Form : name.read();, name.write(Something);
    Pros : Speed

######DataInputStream
    Declare : DataInputStream name = new DataInputStream(InputStream);
    Form : name.read(TYPE)();, name.write(TYPE)();
    Stores Binary Form