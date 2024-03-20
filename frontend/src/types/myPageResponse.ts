import { z } from 'zod';

export const myPageSpotItemSchema = z.object({
  spot_id: z.number().int(),
  place_id: z.number().int(),
  place_name: z.string(),
  is_private: z.boolean(),
  image_url: z.string(),
  created_date: z.coerce
    .date()
    .transform((date) => date.toLocaleDateString('ko-kr')),
  rate: z.number(),
});

export type TMyPageSpot = z.infer<typeof myPageSpotItemSchema>;

export const myPageSpotListSchema = z.object({
  content: z.array(myPageSpotItemSchema),
  total_pages: z.number(),
});

export type TMyPageBookmark = z.infer<typeof myPageBookmarkItemSchema>;
export const myPageBookmarkItemSchema = z.object({
  place_id: z.number().int(),
  place_name: z.string(),
  place_image: z.string(),
  rate: z.number(),
});

export const myPageBookmarkListSchema = z.object({
  bookmarks: z.array(myPageBookmarkItemSchema),
  has_next: z.boolean(),
});

export type TMyPageCourse = z.infer<typeof myPageCourseItemSchema>;

export const myPageCourseItemSchema = z.object({
  course_id: z.number().int(),
  title: z.string(),
  map_static_image_url: z.string(),
  is_private: z.boolean(),
  created_date: z.coerce
    .date()
    .transform((date) => date.toLocaleDateString('ko-kr')),
  rate: z.number(),
  spot_count: z.number(),
});
export const myPageCourseListSchema = z.object({
  content: z.array(myPageCourseItemSchema),
  total_pages: z.number(),
});

const myPageRegionSchema = z.object({
  id: z.number().int(),
  region_name: z.string(),
  selected: z.boolean(),
});
const myPageRegionsSchema = z.object({
  category_name: z.string(),
  regions: z.array(myPageRegionSchema),
});

export const mypageAllAreaSchema = z.object({
  categories: z.array(myPageRegionsSchema),
});

export type TMyPageRegions = z.infer<typeof myPageRegionSchema>;
export type TMyPageAllArea = z.infer<typeof mypageAllAreaSchema>;

export const mypageSpotDetailSchema = z.object({
  place_name: z.string(),
  rate: z.string(),
  place_address: z.string(),
  map_static_image_file_url: z.string(),
  image_urls: z.array(z.string()),
  create_date: z.coerce
    .date()
    .transform((date) => date.toLocaleDateString('ko-kr')),
  description: z.string(),
});

export type TMyPageSpotDetail = z.infer<typeof mypageSpotDetailSchema>;

const myPageCourseDetailSpot = z.object({
  order: z.string(),
  place_name: z.string(),
  image_url_list: z.array(z.string()),
  rate: z.string(),
  description: z.string(),
  create_date: z.coerce
    .date()
    .transform((date) => date.toLocaleDateString('ko-kr')),
});

export const mypageCourseDetailSchema = z.object({
  title: z.string(),
  rate: z.string(),
  map_static_image_url: z.string(),
  description: z.string(),
  spots: z.array(myPageCourseDetailSpot),
});

export type TMyPageCourseDetail = z.infer<typeof mypageCourseDetailSchema>;

export type TMyPageCourseDetailSpot = z.infer<typeof myPageCourseDetailSpot>;
