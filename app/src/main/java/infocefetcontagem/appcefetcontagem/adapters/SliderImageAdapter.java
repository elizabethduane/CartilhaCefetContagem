package infocefetcontagem.appcefetcontagem.adapters;

import android.content.Context;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import infocefetcontagem.appcefetcontagem.R;
import infocefetcontagem.appcefetcontagem.models.Photo;

public class SliderImageAdapter extends PagerAdapter {

    private LayoutInflater inflater;
    private Context context;
    private List<Photo> mPhotoList;

    public SliderImageAdapter(Context context, List<Photo> photoList){
        mPhotoList = photoList;
        this.context = context;
        mPhotoList = photoList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.item_slider_images, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.photo_slider);

        final TextView textView_description = (TextView) imageLayout
                .findViewById(R.id.photo_description) ;

        final TextView textView_position = (TextView) imageLayout
                .findViewById(R.id.photo_position) ;

        imageView.setImageResource(mPhotoList.get(position).getPhotoId());
        textView_description.setText(mPhotoList.get(position).getDescription());
        textView_position.setText(position+1 + "/" +mPhotoList.size());

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public int getCount() {
        return mPhotoList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object.equals(view);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
