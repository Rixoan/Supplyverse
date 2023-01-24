// Generated by view binder compiler. Do not edit!
package com.example.test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test2.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ContactListBackupBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView contactName1;

  @NonNull
  public final TextView firstName1;

  @NonNull
  public final TextView lastName1;

  @NonNull
  public final CircleImageView profileImg1;

  @NonNull
  public final TextView textView251;

  @NonNull
  public final TextView textView271;

  @NonNull
  public final TextView tvEmail1;

  @NonNull
  public final TextView tvNumber1;

  private ContactListBackupBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView contactName1, @NonNull TextView firstName1, @NonNull TextView lastName1,
      @NonNull CircleImageView profileImg1, @NonNull TextView textView251,
      @NonNull TextView textView271, @NonNull TextView tvEmail1, @NonNull TextView tvNumber1) {
    this.rootView = rootView;
    this.contactName1 = contactName1;
    this.firstName1 = firstName1;
    this.lastName1 = lastName1;
    this.profileImg1 = profileImg1;
    this.textView251 = textView251;
    this.textView271 = textView271;
    this.tvEmail1 = tvEmail1;
    this.tvNumber1 = tvNumber1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ContactListBackupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ContactListBackupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.contact_list_backup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ContactListBackupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.contact_name1;
      TextView contactName1 = ViewBindings.findChildViewById(rootView, id);
      if (contactName1 == null) {
        break missingId;
      }

      id = R.id.first_name1;
      TextView firstName1 = ViewBindings.findChildViewById(rootView, id);
      if (firstName1 == null) {
        break missingId;
      }

      id = R.id.last_name1;
      TextView lastName1 = ViewBindings.findChildViewById(rootView, id);
      if (lastName1 == null) {
        break missingId;
      }

      id = R.id.profile_img1;
      CircleImageView profileImg1 = ViewBindings.findChildViewById(rootView, id);
      if (profileImg1 == null) {
        break missingId;
      }

      id = R.id.textView251;
      TextView textView251 = ViewBindings.findChildViewById(rootView, id);
      if (textView251 == null) {
        break missingId;
      }

      id = R.id.textView271;
      TextView textView271 = ViewBindings.findChildViewById(rootView, id);
      if (textView271 == null) {
        break missingId;
      }

      id = R.id.tv_email1;
      TextView tvEmail1 = ViewBindings.findChildViewById(rootView, id);
      if (tvEmail1 == null) {
        break missingId;
      }

      id = R.id.tv_number1;
      TextView tvNumber1 = ViewBindings.findChildViewById(rootView, id);
      if (tvNumber1 == null) {
        break missingId;
      }

      return new ContactListBackupBinding((ConstraintLayout) rootView, contactName1, firstName1,
          lastName1, profileImg1, textView251, textView271, tvEmail1, tvNumber1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}