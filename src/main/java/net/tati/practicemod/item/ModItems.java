package net.tati.practicemod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tati.practicemod.PracticeMod;
import net.tati.practicemod.item.custom.MagicWandItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PracticeMod.MODID);

//    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
//            () -> new Item(new Item.Properties()
//                    .setId(ITEMS.key("example_item"))
//                    .food(new FoodProperties.Builder()
//                            .alwaysEdible()
//                            .nutrition(1)
//                            .saturationModifier(2f)
//                            .build()
//                    )
//            )
//    );


    public static final RegistryObject<Item> STARPIECE =
            ITEMS.register("starpiece", () -> new Item(new Item.Properties().setId(ITEMS.key("starpiece"))));

    public static final RegistryObject<Item> MAGIC_WAND =
            ITEMS.register("magic_wand", () -> new MagicWandItem(new Item.Properties().setId(ITEMS.key("magic_wand")).durability(32)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }


}
