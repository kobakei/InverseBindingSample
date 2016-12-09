package io.github.kobakei.inversebindingsample;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;

/**
 * 独自のバインディングを定義するクラス
 * Created by keisukekobayashi on 2016/12/09.
 */

// STEP 1: ビューから取得したい属性をここに書く
@InverseBindingMethods({
        @InverseBindingMethod(
                type = AbsListView.class,
                attribute = "checkedItemPosition"
        )
})
public class BindingAdapterUtil {

    // STEP 2:
    // <属性名>AttrChanged という属性で、InverseBindingListenerをセットするバインディングを定義する。
    // InverseBindingListener#onChange()が呼ばれるときに、取得したい値が更新される。
    @BindingAdapter(value = "checkedItemPositionAttrChanged")
    public static void setAttrChanged(AbsListView absListView, final InverseBindingListener attrChanged) {
        if (attrChanged == null) {
            absListView.setOnItemClickListener(null);
        } else {
            absListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    attrChanged.onChange();
                }
            });
        }
    }

    // STEP 3:
    // 同じ属性名で、値をビューに反映する方向のバインディングも定義しないとコンパイルが通らないので定義する。
    @BindingAdapter(value = "checkedItemPosition")
    public static void setCheckedItemPosition(AbsListView absListView, int position) {
        absListView.setItemChecked(position, true);
    }
}
