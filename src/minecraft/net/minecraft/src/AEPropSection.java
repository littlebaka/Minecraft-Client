// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package net.minecraft.src;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            AEProps, AEProp

public abstract class AEPropSection
{

    public String name;
    public String header;
    public Map props;
    public Map helpTexts;
    public AEProps aetherProps;

    public AEPropSection(AEProps aeprops, String s, String s1)
    {
        name = s;
        header = s1;
        aetherProps = aeprops;
        props = new LinkedHashMap();
        helpTexts = new HashMap();
        setupProperties();
        aeprops.addSection(this);
    }

    public AEPropSection(AEProps aeprops, String s)
    {
        this(aeprops, s, null);
    }

    public void setupProperties()
    {
        Field afield[] = getClass().getDeclaredFields();
        int i = afield.length;
        for(int j = 0; j < i; j++)
        {
            Field field = afield[j];
            AEProp aeprop = (AEProp)field.getAnnotation(net.minecraft.src.AEProp.class);
            if(aeprop == null)
            {
                continue;
            }
            field.setAccessible(true);
            Class class1 = field.getType();
            String s = formatProp(field, aeprop);
            if(s == null)
            {
                aetherProps.logger.severe((new StringBuilder()).append("Default value of field ").append(field.getName()).append(" is invalid.").toString());
                continue;
            }
            props.put(field, aeprop);
            String s1 = field.getName();
            if(aeprop.help().length() == 0)
            {
                continue;
            }
            String s2 = getTypeHelp(class1, aeprop);
            String s3 = String.format("%s - %s", new Object[] {
                aeprop.help(), s2
            });
            if(aeprop.min() != (-1.0D / 0.0D))
            {
                s3 = (new StringBuilder()).append(s3).append(" >= ").append(String.format(Math.floor(aeprop.min()) != aeprop.min() ? "%.2f" : "%.0f", new Object[] {
                    Double.valueOf(aeprop.min())
                })).toString();
            }
            if(aeprop.max() != (1.0D / 0.0D))
            {
                s3 = (new StringBuilder()).append(s3).append(" < ").append(String.format(Math.floor(aeprop.max()) != aeprop.max() ? "%.2f" : "%.0f", new Object[] {
                    Double.valueOf(aeprop.max())
                })).toString();
            }
            if(aeprop.choices().length != 0)
            {
                s3 = (new StringBuilder()).append(s3).append(String.format(" {%s}", new Object[] {
                    joinString(", ", aeprop.choices())
                })).toString();
            }
            helpTexts.put(field, s3);
        }

    }

    public String getTypeHelp(Class class1, AEProp aeprop)
    {
        if(class1 == Integer.TYPE || class1 == Long.TYPE)
        {
            if(aeprop.isKeybinding())
            {
                return "key";
            } else
            {
                return "number";
            }
        }
        if(class1 == Double.TYPE || class1 == Float.TYPE)
        {
            return "decimal number";
        }
        if(class1 == (java.lang.String.class))
        {
            return "text";
        }
        if(class1 == Boolean.TYPE)
        {
            return "true/false";
        } else
        {
            return "unknown";
        }
    }

    public String joinString(String s, String as[])
    {
        String s1 = "";
        boolean flag = true;
        String as1[] = as;
        int i = as1.length;
        for(int j = 0; j < i; j++)
        {
            String s2 = as1[j];
            if(flag)
            {
                flag = false;
            } else
            {
                s1 = (new StringBuilder()).append(s1).append(s).toString();
            }
            s1 = (new StringBuilder()).append(s1).append(s2).toString();
        }

        return s1;
    }

    public void store(BufferedWriter bufferedwriter)
        throws IOException
    {
        bufferedwriter.newLine();
        bufferedwriter.write((new StringBuilder()).append("## ").append(name).toString());
        bufferedwriter.newLine();
        if(header != null)
        {
            AEProps.writeMultiLine(bufferedwriter, header);
        }
        Iterator iterator = props.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Field field = (Field)iterator.next();
            AEProp aeprop = (AEProp)props.get(field);
            String s = (String)helpTexts.get(field);
            String s1 = formatProp(field, aeprop);
            if(s1 != null)
            {
                if(s != null)
                {
                    bufferedwriter.write((new StringBuilder()).append("# ").append(s).toString());
                    bufferedwriter.newLine();
                }
                bufferedwriter.write((new StringBuilder()).append(field.getName()).append("=").append(s1).toString());
                bufferedwriter.newLine();
            }
        } while(true);
    }

    public boolean loadProp(String s, Field field, AEProp aeprop)
    {
        if(aeprop.choices().length != 0)
        {
            boolean flag = false;
            String as[] = aeprop.choices();
            int i = as.length;
            int j = 0;
            do
            {
                if(j >= i)
                {
                    break;
                }
                String s1 = as[j];
                if(s1.equals(s))
                {
                    flag = true;
                    break;
                }
                j++;
            } while(true);
            if(!flag)
            {
                aetherProps.logger.warning((new StringBuilder()).append("User config value unknown, using default: ").append(s).toString());
                return false;
            }
        }
        Class class1 = field.getType();
        try
        {
            if(class1 == Integer.TYPE)
            {
                loadInt(s, field, aeprop);
            } else
            if(class1 == (java.lang.String.class))
            {
                loadString(s, field, aeprop);
            } else
            if(class1 == Boolean.TYPE)
            {
                loadBool(s, field, aeprop);
            } else
            if(class1 == Float.TYPE)
            {
                loadFloat(s, field, aeprop);
            } else
            if(class1 == Double.TYPE)
            {
                loadDouble(s, field, aeprop);
            } else
            {
                aetherProps.logger.severe((new StringBuilder()).append("Unknown field type: ").append(class1).toString());
                return false;
            }
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            aetherProps.logger.throwing(getClass().getSimpleName(), "loadProp", illegalaccessexception);
            return false;
        }
        return true;
    }

    public void loadConfig(Properties properties)
    {
        Iterator iterator = props.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            Field field = (Field)iterator.next();
            String s = field.getName();
            String s1 = properties.getProperty(s);
            if(s1 != null)
            {
                AEProp aeprop = (AEProp)props.get(field);
                if(!loadProp(s1, field, aeprop))
                {
                    aetherProps.logger.warning(String.format("Failed to load property: %s.%s=%s\n", new Object[] {
                        name, s, s1
                    }));
                } else
                {
                    aetherProps.logger.finest((new StringBuilder()).append("Loaded ").append(s).append("=").append(s1).toString());
                }
            }
        } while(true);
    }

    public boolean loadInt(String s, Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        try
        {
            int i = Integer.parseInt(s);
            if(aeprop.min() != (-1.0D / 0.0D) && (double)i < aeprop.min() || aeprop.max() != (1.0D / 0.0D) && (double)i > aeprop.max())
            {
                aetherProps.logger.warning("Number out of range.");
                return false;
            } else
            {
                field.setInt(this, i);
                return true;
            }
        }
        catch(NumberFormatException numberformatexception) { }
        if(aeprop.isKeybinding())
        {
            s = s.toUpperCase();
            int j = Keyboard.getKeyIndex(s);
            if(!s.equals("NONE") && j == 0)
            {
                aetherProps.logger.warning((new StringBuilder()).append("Unknown keybind name: ").append(s).toString());
                return false;
            } else
            {
                return true;
            }
        }
        if(aeprop.isColor())
        {
            return true;
        } else
        {
            aetherProps.logger.warning("Invalid number format.");
            return false;
        }
    }

    public boolean loadFloat(String s, Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        try
        {
            float f = Float.parseFloat(s);
            if(aeprop.min() != (-1.0D / 0.0D) && (double)f < aeprop.min() || aeprop.max() != (1.0D / 0.0D) && (double)f > aeprop.max())
            {
                aetherProps.logger.warning("Number out of range.");
                return false;
            } else
            {
                field.setFloat(this, f);
                return true;
            }
        }
        catch(NumberFormatException numberformatexception)
        {
            aetherProps.logger.warning("Invalid number format.");
        }
        return false;
    }

    public boolean loadDouble(String s, Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        try
        {
            double d = Double.parseDouble(s);
            if(aeprop.min() != (-1.0D / 0.0D) && d < aeprop.min() || aeprop.max() != (1.0D / 0.0D) && d > aeprop.max())
            {
                aetherProps.logger.warning("Number out of range.");
                return false;
            } else
            {
                field.setDouble(this, d);
                return true;
            }
        }
        catch(NumberFormatException numberformatexception)
        {
            aetherProps.logger.warning("Invalid number format.");
        }
        return false;
    }

    public boolean loadString(String s, Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        field.set(this, s);
        return true;
    }

    public boolean loadBool(String s, Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        field.setBoolean(this, Boolean.valueOf(s).booleanValue());
        return true;
    }

    public String formatProp(Field field, AEProp aeprop)
    {
        Class class1 = field.getType();
        try
        {
            if(class1 == Integer.TYPE)
            {
                return formatInt(field, aeprop);
            }
            if(class1 == (java.lang.String.class))
            {
                return (String)field.get(this);
            }
            if(class1 == Double.TYPE)
            {
                return formatDouble(field, aeprop);
            }
            if(class1 == Float.TYPE)
            {
                return formatFloat(field, aeprop);
            }
            if(class1 == Byte.TYPE)
            {
                return formatByte(field, aeprop);
            }
            if(class1 == Boolean.TYPE)
            {
                return formatBool(field, aeprop);
            } else
            {
                aetherProps.logger.severe(String.format("Unknown field type: %s %s", new Object[] {
                    class1.getSimpleName(), field.getName()
                }));
                return null;
            }
        }
        catch(IllegalAccessException illegalaccessexception)
        {
            aetherProps.logger.throwing(getClass().getSimpleName(), "formatProp", illegalaccessexception);
        }
        return null;
    }

    public String formatFloat(Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        return Float.toString(field.getFloat(this));
    }

    public String formatDouble(Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        return Double.toString(field.getDouble(this));
    }

    public String formatByte(Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        return Byte.toString(field.getByte(this));
    }

    public String formatInt(Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        int i = field.getInt(this);
        if(aeprop.isKeybinding())
        {
            return Keyboard.getKeyName(i);
        }
        if(aeprop.isColor())
        {
            return Integer.toHexString(i);
        } else
        {
            return Integer.toString(i);
        }
    }

    public String formatBool(Field field, AEProp aeprop)
        throws IllegalAccessException
    {
        return Boolean.toString(field.getBoolean(this));
    }
}
