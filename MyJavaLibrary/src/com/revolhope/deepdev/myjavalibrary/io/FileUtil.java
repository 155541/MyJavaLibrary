package com.revolhope.deepdev.myjavalibrary.io;


public class FileUtil
{
    // ======================================================================
    // ======================================================================
    // =                            STATIC METHODS                          =
    // ======================================================================
    // ======================================================================
    
    /**
     * TODO
     */
    public static boolean makeDir(String absolutePath) throws SecurityException
    {
        return new File(absolutePath).mkdirs();
    }
    
    /**
     * TODO
     */
    public static File createFile(String absolutePath) throws IOException, SecurityException
    {
        File f = new File(absolutePath);
        if (f.createNewFile())
        {
            return f;
        }
        else
        {
            throw new IOException("File could not be created");
        }
    }
    
    /**
     * TODO https://docs.oracle.com/javase/7/docs/api/java/io/File.html#createTempFile()
     */
    public static File createTemporaryFile(String fileName, String parentAbsolutePath) throws IOException, SecurityException, IllegalArgumentException
    {   
        String prefix = null;
        String suffix = null;
        
        if (fileName.constains("."))
        {
            prefix = fileName.split("\\.")[0];
            suffix = fileName.split("\\.")[1];
        }
        
        if (parentAbsolutePath != null)
        {
            File parent = new File(parentAbsolutePath);
            if (parent.exists())
            {
                if (prefix != null && suffix != null)
                {
                    return File.createTempFile(prefix, suffix, parent);
                }
                else
                {
                    return File.createTempFile(fileName, null, parent);
                }
            }
            else
            {
                throw new IOException("Parent provided does not exists");
            }
        }
        else
        {
            if (prefix != null && suffix != null)
            {
                return File.createTempFile(prefix, suffix, null);
            }
            else
            {
                return File.createTempFile(fileName, null, null);
            }
        }
    }
    
    /**
     * TODO
     */
    public static File rename(File oldFile, String newFileName) throws SecurityException, NullPointerException 
    {
        String[] segments = oldFile.split(File.separator);
        int size = segments.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i<size ; i++)
        {
            if (i == size-1)
            {
                sb.append(newFileName);
            }
            else
            {
                sb.append(segments[i]);
            }
            sb.append(File.separator);
        }
        
        return oldFile.renameTo(new File(sb.toString()));
    }
    
    /**
     * TODO
     */
    public static void move(File fileToMove, String newLocation) throws InvalidPathException
    {
        Path target = Paths.get(newLocation);
        Path origin = fileToMove.toPath();
        Files.move(origin, target, /*StandardCopyOption.*/REPLACE_EXISTING);
    }
    
    // ======================================================================
    // ======================================================================
    // =                          NON-STATIC METHODS                        =
    // ======================================================================
    // ======================================================================
    
    private File _file;
    private String absPath;
    
    /**
     * TODO
     */
    public void setAbsolutePath(String path)
    {
        this.absPath = path;
    }
    
    /**
     * TODO
     */
    public boolean createDirectory(HandleException exceptionCallback)
    {
        if (absPath == null)
        {
            exceptionCallback.throw(new Exception("Absolute path does not set"));
            return false;
        }
        try 
        {
            this._file = new File(absPath);
            return this._file.mkdirs();   
        }
        catch(SecurityException exc)
        {
            exceptionCallback.throw(exc);
            return false;
        }
    }
    
    /**
     * TODO
     */
    public boolean createFile(HandleException exceptionCallback)
    {
        if (absPath == null)
        {
            exceptionCallback.throw(new IOException("Absolute path does not set"));
            return false;
        }
        try 
        {
            this._file = new File(absPath);
            if (!_file.exists())
            {
                return _file.createNewFile(); 
            }
            else
            {
                exceptionCallback.throw(new IOException("The file you are trying to create already exists");
                return false;
            }
        }
        catch(SecurityException | IOException exc)
        {
            exceptionCallback.throw(exc);
            return false;
        }
    }
    
    /**
     * TODO
     */
    public boolean createTemporaryFile(HandleException exceptionCallback) 
    {
        if (absPath == null)
        {
            this._file = null;
            exceptionCallback.throw(new IOException("Absolute path does not set"));
            return false;
        }
        try
        {
            String[] segments = absolutePath.split(File.separator);
            int size = segments.length;
            File parent = null;
            String fileName = null;
            String prefix = null;
            String suffix = null;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size ; i++)
            {
                if (i == size-1 && segments[i].contains(".")) 
                {
                    prefix = segments[i].split("\\.")[0];
                    suffix = segments[i].split("\\.")[1];
                }
                else if (i == size-1)
                {
                    fileName = segments[i];
                }
                else
                {
                    sb.append(segments[i]);
                    sb.append.(File.separator);
                }
            }
            
            parent = new File(sb.toString());
            
            if (parent != null && parent.exists())
            {
                if (prefix != null && suffix != null)
                {
                    this._file = File.createTempFile(prefix, suffix, parent);
                    return true;
                }
                else if (fileName != null)
                {
                    this._file = File.createTempFile(fileName, null, parent);
                    return true;
                }
                else
                {
                    this._file = null;
                    exceptionCallback.throw(new IOException("It was not possible to retreive fileName from path set."));
                    return false;
                }
            }
            else if (prefix != null && suffix != null)
            {
                this._file = File.createTempFile(prefix, suffix, null);
                return true;
            }
            else
            {
                if (fileName != null)
                {
                    this._file = File.createTempFile(fileName, null, null);
                    return true;
                }
                else
                {
                    this._file = null;
                    exceptionCallback.throw(new IOException("It was not possible to retreive fileName from path set."));
                    return false;
                }
            }

        }
        catch(Exception exc)
        {
            this._file = null;
            exceptionCallback.throw(exc);
            return false;
        }
    }
    
    public boolean rename(String oldAbsolutePath, String newName)
    {
        String[] segments = oldAbsolutePath.split(File.separator);
        int length = segments.length;
        this._file = new File(oldAbsolutePath);
        StribgBuilder sb = new StringBuilder();
        for (int i = 0 ; i< length ; i++)
        {
            if (i != length)
            {
                sb.append(newName);
            }
            else
            {
                sb.append(segments[i]);
            }
            sb.append(File.separator);
        }
                
        if(_file != null && _file.exists())
        {
            return this._file.renameTo(new File(sb.toString()));
        }
        else
        {
            new IOException("It cannot get file with old absolute path provided");
        }
    }
    
    public static boolean exists(File file)
    {
        return file.exists() && Files.exists(file.getAbsolutePath(), LinkOption.NOFOLLOW_LINKS);
    }
    
    public static boolean exists(String absolutePath)
    {
        return file.exists() && Files.exists(file.getAbsolutePath(), LinkOption.NOFOLLOW_LINKS);
    }
    
    public boolean exists()
    {
        if (this._file != null)
        {
            return this._file.exists() && Files.exists(this._file.getAbsolutePath(), LinkOption.NOFOLLOW_LINKS);
        }
        else
        {
            throw new IOException("There is no file created.. You have to call first methods like: 'createFile', 'createTemporaryFile', etc. See documentation");
        }
    }
    
    public File getFile() throws Exception
    {
        if (_file != null) return _file;
        else throw new Exception("There is no file created.. You have to call first methods like: 'createFile', 'createTemporaryFile', etc. See documentation");
    }
    
    public void writeFile()
    {
        
    }
    
    public OutputStream readFile()
    {
        
    }
}
