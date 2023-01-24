// Generated by view binder compiler. Do not edit!
package com.example.test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomNotificationBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView imageviewNotification;

  @NonNull
  public final TextView tvNotificationDesc;

  @NonNull
  public final TextView tvNotificationTitle;

  private CustomNotificationBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView imageviewNotification, @NonNull TextView tvNotificationDesc,
      @NonNull TextView tvNotificationTitle) {
    this.rootView = rootView;
    this.imageviewNotification = imageviewNotification;
    this.tvNotificationDesc = tvNotificationDesc;
    this.tvNotificationTitle = tvNotificationTitle;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom_notification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomNotificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageview_notification;
      ImageView imageviewNotification = ViewBindings.findChildViewById(rootView, id);
      if (imageviewNotification == null) {
        break missingId;
      }

      id = R.id.tv_notification_desc;
      TextView tvNotificationDesc = ViewBindings.findChildViewById(rootView, id);
      if (tvNotificationDesc == null) {
        break missingId;
      }

      id = R.id.tv_notification_title;
      TextView tvNotificationTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvNotificationTitle == null) {
        break missingId;
      }

      return new CustomNotificationBinding((RelativeLayout) rootView, imageviewNotification,
          tvNotificationDesc, tvNotificationTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}