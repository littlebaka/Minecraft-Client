package net.minecraft.src;

public enum EnumBackpackMaterial
{
		BACKPACK("BACKPACK", 0, 0);
    /*
        public static final EnumArmorMaterial CLOTH;
        public static final EnumArmorMaterial CHAIN;
        public static final EnumArmorMaterial IRON;
        public static final EnumArmorMaterial GOLD;
        public static final EnumArmorMaterial DIAMOND;
    */
        private int field_40577_f;

        private static final EnumBackpackMaterial allBackpackMaterials[]; /* synthetic field */
    /*
        public static final EnumArmorMaterial[] values()
        {
            return (EnumArmorMaterial[])allArmorMaterials.clone();
        }

        public static EnumArmorMaterial valueOf(String s)
        {
            return (EnumArmorMaterial)Enum.valueOf(net.minecraft.src.EnumArmorMaterial.class, s);
        }
    */
        private EnumBackpackMaterial(String s, int i, int j)
        {
//            super(s, i);
            field_40577_f = j;
        }

        static 
        {
    /*
            CLOTH = new EnumArmorMaterial("CLOTH", 0, 5, new int[] {
                1, 3, 2, 1
            }, 15);
            CHAIN = new EnumArmorMaterial("CHAIN", 1, 15, new int[] {
                2, 5, 4, 1
            }, 12);
            IRON = new EnumArmorMaterial("IRON", 2, 15, new int[] {
                2, 6, 5, 2
            }, 9);
            GOLD = new EnumArmorMaterial("GOLD", 3, 7, new int[] {
                2, 5, 3, 1
            }, 25);
            DIAMOND = new EnumArmorMaterial("DIAMOND", 4, 33, new int[] {
                3, 8, 6, 3
            }, 10);
    */
            allBackpackMaterials = (new EnumBackpackMaterial[] {
                BACKPACK
            });
        }
}
