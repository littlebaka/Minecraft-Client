package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class WeaponStorage
{

 public boolean isIndependant;
 public boolean isEntity;
 public boolean useMaterials;
 public String weaponName;
 public Item weaponItem;
 public int entityID;
 public boolean enabled;
 private int itemID;
 private Map itemIDsWithMaterial;
 public static final String materials[] = {
     "wood", "stone", "iron", "diamond", "gold"
 };
 public static Map propsMap = new HashMap();

 private WeaponStorage(String s, boolean flag, boolean flag1, boolean flag2)
 {
     weaponName = s;
     isEntity = flag1;
     useMaterials = flag;
     isIndependant = flag2;
     if(useMaterials)
     {
         itemIDsWithMaterial = new HashMap();
     }
 }

 public void setItemID(int i)
 {
     if(useMaterials)
     {
         throw new IllegalStateException("Weapon uses materials. Use setItemIDs instead.");
     } else
     {
         itemID = i;
         return;
     }
 }

 public int getItemID()
 {
     if(useMaterials)
     {
         throw new IllegalStateException("Weapon uses materials. Use getItemIDs instead.");
     } else
     {
         return itemID;
     }
 }

 public void setItemIDs(int ai[])
 {
     if(!useMaterials)
     {
         throw new IllegalStateException("Weapon does not use materials. Use setItemID instead.");
     }
     for(int i = 0; i < materials.length; i++)
     {
         itemIDsWithMaterial.put(materials[i], Integer.valueOf(ai[i]));
     }

 }

 public int[] getItemIDs()
 {
     if(!useMaterials)
     {
         throw new IllegalStateException("Weapon does not use materials. Use getItemID instead.");
     }
     int ai[] = new int[materials.length];
     for(int i = 0; i < materials.length; i++)
     {
         try
         {
             ai[i] = ((Integer)itemIDsWithMaterial.get(materials[i])).intValue();
         }
         catch(NullPointerException nullpointerexception)
         {
             ai[i] = 0;
         }
     }

     return ai;
 }

 public static boolean isEnabled(String s)
 {
     return getWeapon(s).enabled;
 }

 public static void addWeapon(String s, boolean flag, boolean flag1, boolean flag2)
 {
     propsMap.put(s, new WeaponStorage(s, flag, flag1, flag2));
 }

 public static WeaponStorage getWeapon(String s)
 {
     return (WeaponStorage)propsMap.get(s);
 }

}
