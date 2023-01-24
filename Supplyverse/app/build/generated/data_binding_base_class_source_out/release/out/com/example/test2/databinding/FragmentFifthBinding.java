// Generated by view binder compiler. Do not edit!
package com.example.test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test2.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentFifthBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final Button btLogout;

  @NonNull
  public final Button btMap;

  @NonNull
  public final CircleImageView circleImageView2;

  @NonNull
  public final TextView currentLocation;

  @NonNull
  public final TextView favorit;

  @NonNull
  public final NestedScrollView frameLayout7;

  @NonNull
  public final TextView histori;

  @NonNull
  public final ImageButton imageButton;

  @NonNull
  public final TextView textView21;

  @NonNull
  public final TextView usernameHolder;

  private FragmentFifthBinding(@NonNull NestedScrollView rootView, @NonNull Button btLogout,
      @NonNull Button btMap, @NonNull CircleImageView circleImageView2,
      @NonNull TextView currentLocation, @NonNull TextView favorit,
      @NonNull NestedScrollView frameLayout7, @NonNull TextView histori,
      @NonNull ImageButton imageButton, @NonNull TextView textView21,
      @NonNull TextView usernameHolder) {
    this.rootView = rootView;
    this.btLogout = btLogout;
    this.btMap = btMap;
    this.circleImageView2 = circleImageView2;
    this.currentLocation = currentLocation;
    this.favorit = favorit;
    this.frameLayout7 = frameLayout7;
    this.histori = histori;
    this.imageButton = imageButton;
    this.textView21 = textView21;
    this.usernameHolder = usernameHolder;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFifthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFifthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_fifth, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFifthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_logout;
      Button btLogout = ViewBindings.findChildViewById(rootView, id);
      if (btLogout == null) {
        break missingId;
      }

      id = R.id.bt_map;
      Button btMap = ViewBindings.findChildViewById(rootView, id);
      if (btMap == null) {
        break missingId;
      }

      id = R.id.circleImageView2;
      CircleImageView circleImageView2 = ViewBindings.findChildViewById(rootView, id);
      if (circleImageView2 == null) {
        break missingId;
      }

      id = R.id.current_location;
      TextView currentLocation = ViewBindings.findChildViewById(rootView, id);
      if (currentLocation == null) {
        break missingId;
      }

      id = R.id.favorit;
      TextView favorit = ViewBindings.findChildViewById(rootView, id);
      if (favorit == null) {
        break missingId;
      }

      NestedScrollView frameLayout7 = (NestedScrollView) rootView;

      id = R.id.histori;
      TextView histori = ViewBindings.findChildViewById(rootView, id);
      if (histori == null) {
        break missingId;
      }

      id = R.id.imageButton;
      ImageButton imageButton = ViewBindings.findChildViewById(rootView, id);
      if (imageButton == null) {
        break missingId;
      }

      id = R.id.textView21;
      TextView textView21 = ViewBindings.findChildViewById(rootView, id);
      if (textView21 == null) {
        break missingId;
      }

      id = R.id.usernameHolder;
      TextView usernameHolder = ViewBindings.findChildViewById(rootView, id);
      if (usernameHolder == null) {
        break missingId;
      }

      return new FragmentFifthBinding((NestedScrollView) rootView, btLogout, btMap,
          circleImageView2, currentLocation, favorit, frameLayout7, histori, imageButton,
          textView21, usernameHolder);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
