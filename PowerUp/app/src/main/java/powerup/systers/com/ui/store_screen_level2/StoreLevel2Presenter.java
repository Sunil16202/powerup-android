package powerup.systers.com.ui.store_screen_level2;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import powerup.systers.com.R;
import powerup.systers.com.data.DataSource;
import powerup.systers.com.data.StoreItem;
import powerup.systers.com.ui.store_screen_level2.StoreLevel2Contract;
import powerup.systers.com.utils.PowerUpUtils;

public class StoreLevel2Presenter implements StoreLevel2Contract.IStoreLevel2Presenter {

    private StoreLevel2Contract.IStoreLevel2View view;
    private DataSource source;
    private Context context;

    public StoreLevel2Presenter(StoreLevel2Contract.IStoreLevel2View view, DataSource source, Context context) {
        this.view = view;
        this.source = source;
        this.context = context;
    }

    @Override
    public void calculateEyeValue(int value) {
        String eyeImageName = context.getResources().getString(R.string.hs_eyes);
        eyeImageName = eyeImageName + value;
        R.drawable ourRID = new R.drawable();
        java.lang.reflect.Field photoNameField;
        try {
            photoNameField = ourRID.getClass().getField(eyeImageName);
            view.updateAvatarEye(photoNameField.getInt(ourRID));
        } catch (NoSuchFieldException | IllegalAccessException
                | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void calculateHairValue(int value) {
        String hairImageName = context.getResources().getString(R.string.hs_hair);
        hairImageName = hairImageName + value;
        R.drawable ourRID = new R.drawable();
        java.lang.reflect.Field photoNameField;
        try {
            photoNameField = ourRID.getClass().getField(hairImageName);
            view.updateAvatarHair(photoNameField.getInt(ourRID));
        } catch (NoSuchFieldException | IllegalAccessException
                | IllegalArgumentException error) {
            Log.e("StorePresenter", "Error due to :" + hairImageName);
        }
    }

    @Override
    public void calculateSkinValue(int value) {
        String skinmageName = context.getResources().getString(R.string.hs_skin);
        skinmageName = skinmageName + value;
        R.drawable ourRID = new R.drawable();
        java.lang.reflect.Field photoNameField;
        try {
            photoNameField = ourRID.getClass().getField(skinmageName);
            view.updateAvatarSkin(photoNameField.getInt(ourRID));
        } catch (NoSuchFieldException | IllegalAccessException
                | IllegalArgumentException error) {
            Log.e("StorePresenter", "Error due to :" + skinmageName);
        }
    }

    @Override
    public void calculateClothValue(int value) {
        String clothImageName = context.getResources().getString(R.string.hs_dress_avatar);
        clothImageName = clothImageName + value;
        R.drawable ourRID = new R.drawable();
        java.lang.reflect.Field photoNameField;
        try {
            photoNameField = ourRID.getClass().getField(clothImageName);
            view.updateAvatarCloth(photoNameField.getInt(ourRID));
        } catch (NoSuchFieldException | IllegalAccessException
                | IllegalArgumentException error) {
            Log.e("StorePresenter", "Error due to :" + clothImageName);
        }
    }

    @Override
    public void calculateAccessoryValue(int value) {
        if(value > 0) {
            String accessoryImageName = context.getResources().getString(R.string.hs_acc);
            accessoryImageName = accessoryImageName + value;
            R.drawable ourRID = new R.drawable();
            java.lang.reflect.Field photoNameField;
            try {
                photoNameField = ourRID.getClass().getField(accessoryImageName);
                view.updateAvatarAccessory(photoNameField.getInt(ourRID));
            } catch (NoSuchFieldException | IllegalAccessException
                    | IllegalArgumentException error) {
                Log.e("StorePresenter", "Error due to :" + accessoryImageName);
            }
        }

    }

    @Override
    public void setValues() {
        calculateEyeValue(source.getCurrentEyeValue());
        calculateClothValue(source.getCurrentClothValue());
        calculateHairValue(source.getCurrentHairValue());
        calculateSkinValue(source.getCurrentSkinValue());
        calculateAccessoryValue(source.getCurrentAccessoriesValue());
    }

    @Override
    public List<List<StoreItem>> createDataList() {
        List<List<StoreItem>> allDataSet = new ArrayList<>();

        List<StoreItem> storeHair = new ArrayList<>();
        List<StoreItem> storeClothes = new ArrayList<>();
        List<StoreItem> storeAccessories = new ArrayList<>();

        allDataSet.add(storeHair);
        allDataSet.add(storeClothes);
        allDataSet.add(storeAccessories);

        for (int i = 0; i < PowerUpUtils.HAIR_IMAGES.length; i++) {
            StoreItem item = new StoreItem(PowerUpUtils.HAIR_POINTS_TEXTS[i], PowerUpUtils.HAIR_IMAGES[i]);
            allDataSet.get(0).add(item);
        }
        for (int i = 0; i < PowerUpUtils.HS_CLOTHES_IMAGES.length; i++) {
            StoreItem item = new StoreItem(PowerUpUtils.HS_CLOTHES_POINTS_TEXTS[i], PowerUpUtils.HS_CLOTHES_IMAGES[i]);
            allDataSet.get(1).add(item);
        }
        for (int i = 0; i < PowerUpUtils.ACCESSORIES_IMAGES.length; i++) {
            StoreItem item = new StoreItem(PowerUpUtils.ACCESSORIES_POINTS_TEXTS[i], PowerUpUtils.ACCESSORIES_IMAGES[i]);
            allDataSet.get(2).add(item);
        }
        return allDataSet;
    }
}
