//AVAILABLE FROM 0.2.3 AND ON

import mods.metallurgyreforged.Crusher;
import mods.metallurgyreforged.Alloyer;
//import integration classes you need ^^^



//Adds a new Crusher recipe
//Crusher.addRecipe(IIngrendient input, IItemStack output);
Crusher.addRecipe(<minecraft:planks:*>, <metallurgy:oureclase_dust>);

//Recipe Experience Support
//Crusher.addRecipe(IIngrendient input, IItemStack output, float experience);
Crusher.addRecipe(<metallurgy:manganese_block>, <minecraft:gravel>, 0.5);


//Removes an existing recipe from the Crusher recipes list
//Crusher.removeRecipe(IItemStack output)
Crusher.removeRecipe(<metallurgy:adamantine_dust>);



//Adds a new Alloyer recipe
//Alloyer.addRecipe(IIngrendient input1, IIngredient input2, IItemStack output);
Alloyer.addRecipe(<minecraft:planks:*>, <minecraft:planks:*>, <metallurgy:oureclase_block>);

//Recipe Experience Support
//Alloyer.addRecipe(IIngrendient input1, IIngredient input2, IItemStack output, float experience);
Alloyer.addRecipe(<metallurgy:inolashite_ingot>, <ore:ingotOrichalcum>, <minecraft:bed>, 1.0F);


//Removes an existing recipe from the Alloyer recipes list
//Alloyer.removeRecipe(IItemStack output)
Alloyer.removeRecipe(<metallurgy:tartarite_ingot>);